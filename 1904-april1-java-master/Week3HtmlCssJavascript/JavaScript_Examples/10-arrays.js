let arr = [5,100,2,89,3,55,4,3,22]; //create an array
//filter through an array
let filtered = arr.filter((x)=>{
    if(x != 3){
        return false;
    }else{
        return true;
    }
})
console.log(arr);
console.log(filtered);
//forEach
arr.forEach((element) =>{
    console.log(element);
});

//checks to see if some element inside array meets some condition
console.log(arr.some(element => element=== 3));