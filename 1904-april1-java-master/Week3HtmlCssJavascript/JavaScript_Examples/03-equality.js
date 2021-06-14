/*
    == vs ===
    == tries its best to ignore type and jsut compare value anyway
        this is part of type coercion
    === will compare both type and value
*/

function compare(one,two){
    console.log(`
    one = ${one}, and is type: ${typeof(one)}
    two = ${two}, and is type: ${typeof(two)}
        one == two evaluates to: ${one == two}
        one === two evaluates to: ${one===two}
    `);
}

compare(5,'5');
compare(97, 'a');
compare(null,undefined); 
compare([],[]);// objects not equal t oother instances of objects
compare(true, false);
compare(1/'g',2/[])//NaN is not equal to itself
compare() //note that this will input two undefineds
compare(Infinity,Infinity);// true true
compare(Infinity,-Infinity);//false false