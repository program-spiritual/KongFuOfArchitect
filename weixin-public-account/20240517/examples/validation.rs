// 引入jsonwebtoken包中必要的模块和类型，用于处理JWT令牌。
use jsonwebtoken::errors::ErrorKind;
use jsonwebtoken::{decode, encode, Algorithm, DecodingKey, EncodingKey, Header, Validation};

// 引入Serde的Deserialize和Serialize特性，用于序列化和反序列化数据结构。
use serde::{Deserialize, Serialize};

// 定义一个结构体Claims，用来表示JWT令牌的有效载荷（payload）。
#[derive(Debug, Serialize, Deserialize)]
struct Claims {
    aud: String,      // "aud"（观众）声明
    sub: String,      // "sub"（主题）声明
    company: String,  // 自定义声明，用于公司信息
    exp: u64,         // "exp"（到期时间）声明
}

fn main() {
    // 定义一个用于签名JWT令牌的密钥。
    let key = b"secret";

    // 使用字段值创建Claims实例。
    let my_claims = Claims {
        aud: "me".to_owned(),             // 观众声明
        sub: "b@b.com".to_owned(),        // 主题声明
        company: "ACME".to_owned(),       // 公司自定义声明
        exp: 10000000000,                 // 到期时间声明
    };

    // 使用HS256算法和密钥，将Claims编码成一个JWT令牌。
    let token = match encode(&Header::default(), &my_claims, &EncodingKey::from_secret(key)) {
        Ok(t) => t,              // 如果成功，返回令牌
        Err(_) => panic!(),      // 如果编码过程中出错，则产生panic。实际应用中应该返回错误
    };

    // 使用HS256算法初始化Validation结构体。
    let mut validation = Validation::new(Algorithm::HS256);
    // 设置期望的"sub"（主题）声明为"b@b.com"。
    validation.sub = Some("b@b.com".to_string());
    // 设置期望的"aud"（观众）声明为"me"。
    validation.set_audience(&["me"]);
    // 指定必须的声明（在这个例子中是"exp"、"sub"和"aud"）。
    validation.set_required_spec_claims(&["exp", "sub", "aud"]);

    // 使用相同的密钥和验证约束，对JWT令牌进行解码。
    let token_data = match decode::<Claims>(&token, &DecodingKey::from_secret(key), &validation) {
        Ok(c) => c,                    // 如果成功，返回令牌数据
        Err(err) => match *err.kind() {
            // 如果令牌解码失败，处理特定的错误。
            ErrorKind::InvalidToken => panic!("Token is invalid"),  // 如果令牌无效，则产生panic。
            ErrorKind::InvalidIssuer => panic!("Issuer is invalid"), // 如果发行者无效，则产生panic。
            _ => panic!("Some other errors"),                        // 对于其他错误，产生panic。
        },
    };

    // 打印解码后的令牌中的声明和头部信息。
    println!("{:?}", token_data.claims);
    println!("{:?}", token_data.header);
}
