using Microsoft.AspNetCore.Hosting;

namespace startup001
{
    public class StartupFilterOne : IStartupFilter
    {
        public Action<IApplicationBuilder> Configure(Action<IApplicationBuilder> next)
        {
            return builder => 
            {
                builder.Use(async (httpContext, _next) => 
                {
                    Console.WriteLine("-----StartupFilterOne-----");
                    await _next(httpContext);
                });
                next(builder);
            };
        }
    }
}