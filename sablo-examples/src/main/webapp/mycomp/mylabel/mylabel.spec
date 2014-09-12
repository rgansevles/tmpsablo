{
	"name": "mylabel",
	"displayName": "My Label",
	"definition": "mycomp/mylabel/mylabel.js",
	"model":
	{
		 "somestring" : "string", 
		 "somenumber" : "int"
	},
	"__handlers":
	{
		"onActionMethodID" : "function"
	},
	"api":
	{
		 "doAlert": {"parameters":[ { "name":"message", "type":"string"}] }
	}
}