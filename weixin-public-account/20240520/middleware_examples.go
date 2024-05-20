package main // 声明 main 包，表明这是一个可执行程序的入口包

import (
	"context"     // 导入context包，用于创建和管理上下文
	"fmt"         // 导入fmt包，用于格式化输出
	"github.com/go-dew/dew" // 导入dew包，可能是一个第三方库，用于处理命令或事件
	"database/sql" // 导入sql包，用于数据库操作
)

// TransactionalMiddleware 创建一个用于处理事务的中间件
func TransactionalMiddleware(db *sql.DB) func(next dew.Middleware) dew.Middleware {
	// 返回一个函数，这个函数接收一个dew.Middleware类型的参数，并返回一个dew.Middleware类型
	return func(next dew.Middleware) dew.Middleware {
		// 返回一个中间件函数，它接收一个dew.Context类型的参数，并返回一个错误类型
		return dew.MiddlewareFunc(func(ctx dew.Context) error {
			// 检查上下文中是否已经存在事务
			if tx, ok := ctx.Context().Value("tx").(*sql.Tx); ok && tx != nil {
				// 如果事务已经存在，则直接调用下一个中间件，不再创建新的事务
				return next.Handle(ctx)
			}

			// 开始一个新的事务
			tx, err := db.BeginTx(ctx.Context(), nil)
			if err != nil {
				// 如果开始事务失败，返回错误信息
				return fmt.Errorf("failed to begin transaction: %w", err)
			}

			// 将事务附加到上下文中
			txCtx := context.WithValue(ctx.Context(), "tx", tx)
			ctx = ctx.WithContext(txCtx)

			// 执行命令
			err = next.Handle(ctx)
			if err != nil {
				// 如果执行过程中出现错误，回滚事务
				if rbErr := tx.Rollback(); rbErr != nil {
					// 如果回滚事务失败，返回回滚失败的错误信息
					return fmt.Errorf("rollback failed: %w", rbErr)
				}
				// 返回执行过程中的错误
				return err
			}

			// 如果一切顺利，提交事务
			if commitErr := tx.Commit(); commitErr != nil {
				// 如果提交事务失败，返回提交失败的错误信息
				return fmt.Errorf("commit failed: %w", commitErr)
			}

			// 返回nil，表示中间件执行成功，没有错误
			return nil
		})
	}
}
