//You can use any value in a boolean context and it will be assigned
//a truthy or a falsey value
function checkTruthy(input){
    console.log(`
    input = ${input}, and is typeof: ${typeof(input)}
    and input is ${!!input}`) // !! will check if input is true or false
}
checkTruthy(true);
checkTruthy(1);
checkTruthy(0);
checkTruthy(NaN);
checkTruthy(null);
checkTruthy(undefined);
checkTruthy({});
checkTruthy([]);
checkTruthy('');
checkTruthy("");
checkTruthy(" ");
checkTruthy("hello");
checkTruthy("false");
checkTruthy(Infinity);
checkTruthy(checkTruthy);
checkTruthy(checkTruthy());
checkTruthy(checkTruthy(checkTruthy));
let a = checkTruthy;
console.log(a(3));
checkTruthy(-200);