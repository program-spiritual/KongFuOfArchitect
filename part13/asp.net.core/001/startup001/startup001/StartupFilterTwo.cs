namespace startup001;

public class StartupFilterTwo : IStartupFilter
{
    public Action<IApplicationBuilder> Configure(Action<IApplicationBuilder> next)
    {
        return builder =>
        {
            next(builder);
            builder.Use(async (httpContext, _next) => 
            {
                Console.WriteLine("-----StartupFilterTwo-----");
                await _next(httpContext);
            });
        };
    }
}