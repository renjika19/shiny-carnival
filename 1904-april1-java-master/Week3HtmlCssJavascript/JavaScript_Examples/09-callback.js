//a callback function is simply a functio nthat is the parameter
//of another function

function caller (callbackParam){
    console.log(`
    caller called with param: ${callbackParam}`);
    callbackParam(5,6);
}

// function callback(one,two){
//     console.log(`invoked with params ${one} and ${two}`);
// }

// caller(callback);

caller((x,y)=>{
    console.log(`x + y = ${x+y}`) 
});//arrow notation functions can be callback functions too!



