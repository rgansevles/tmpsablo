name: 'mylabel',
displayName: 'My Label',
definition: 'mycomp/mylabel/mylabel.js',
model:
{
    dataprovider: 'dataprovider',
    dataprovider1: 'dataprovider'
},
handlers:
{
        onActionMethodID : 'function'
},
api: {
	getSomething:{
		returns: 'int',
    }, 
	doAlert:{
		parameters:[{'message':'string'}]
	}
}
