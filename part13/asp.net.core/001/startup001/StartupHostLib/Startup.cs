using Microsoft.AspNetCore.Hosting;

[assembly: HostingStartup(typeof(StartupHostLib.OneHostingStartup))]
namespace StartupHostLib
{

    public class OneHostingStartup : IHostingStartup
    {
        public void Configure(IWebHostBuilder builder)
        {
            builder.ConfigureAppConfiguration((config) => 
            {
                // Console.WriteLine("ConfigureAppConfiguration");
            });

            builder.ConfigureServices(services =>
            {

                // Console.WriteLine("ConfigureServices");
            });

            // builder.Configure(app =>
            // {
            //     Console.WriteLine("Configure");
            // });
        }
    }
}