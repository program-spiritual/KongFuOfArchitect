using startup001;

[assembly: HostingStartup(typeof(OneHostingStartup))]
namespace startup001
{

    public class OneHostingStartup : IHostingStartup
    {
        public void Configure(IWebHostBuilder builder)
        {
            builder.ConfigureAppConfiguration((config) => 
            {
                Console.WriteLine("ConfigureAppConfiguration");
            });

            builder.ConfigureServices(services =>
            {
                services.AddTransient<IStartupFilter, StartupFilterTwo>();
                services.AddTransient<IStartupFilter, StartupFilterOne>();
                Console.WriteLine("ConfigureServices");
            });

            // builder.Configure(app =>
            // {
            //     Console.WriteLine("Configure");
            // });
        }
    }
}