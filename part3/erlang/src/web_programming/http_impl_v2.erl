-module(http_impl_v2).

%% API
-export([start/0,service/3]).

start()->
  inets:start(httpd,[
    {modules,[
      mod_alias,
      mod_auth,
      mod_esi,
      mod_actions,
      mod_cgi,
      mod_dir,
      mod_get,
      mod_head,
      mod_log,
      mod_disk_log
    ]},
    {port,8081},
    {server_name,"http_impl_v2"},
    {server_root,"D://tmp"},
    {document_root,"D://tmp/htdocs"},
    {erl_script_alias, {"/erl", [http_impl_v2]}},
    {error_log, "error.log"},
    {security_log, "security.log"},
    {transfer_log, "transfer.log"},

    {mime_types,[
      {"html","text/html"}, {"css","text/css"}, {"js","application/x-javascript"} ]}
  ]).

service(SessionID, _Env, _Input) -> mod_esi:deliver(SessionID, [
  "Content-Type: text/html\r\n\r\n", "<html><body>Hello, World!</body></html>" ]).