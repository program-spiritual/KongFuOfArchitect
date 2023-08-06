
using startup001;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddTransient<IStartupFilter, StartupFilterOne>(); //注入 StartupFilterOne
builder.Services.AddTransient<IStartupFilter, StartupFilterTwo>(); //注入 StartupFilterTwo
// 注册服务
// Add services to the container.
builder.Services.AddRazorPages();
builder.Services.AddControllersWithViews();
var app = builder.Build();
// 配置 http 请求管道
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Error");
    app.UseHsts();
}
app.UseHttpsRedirection();
app.UseStaticFiles();
app.UseAuthorization();
app.MapGet("/", () => "Hello World!");
app.MapDefaultControllerRoute();
app.MapRazorPages();
app.Run();

