//prototypal inheritance is one way that  inheritance can be perfomred
//in JS (using a class and extending it is another way)
var animal={
    tail:'None',
    species:'None',
    getStats: function(){
        return this.tail + ' ' + this.species;
        //when the 'this' keyword is used, it is used within an object's
        //method (function that is a property of an object) so, it will
        // refer to the animal object
    }
}

var tigger = {
    tail:"springy",
    stripes:"some"
}
//All objects have a hidden property in JS called a prototype
//if you attempt to access a property or a method that is not present in an
//object, JS will check for it in its prototype
//you can access the prototype and set it equal to something in the
//following example:
tigger.__proto__=animal; //this is basically saying that 'animal' is the
//prototype for tigger
console.log(tigger.tail);// you get the property of the object, not the
//proto, if possible
console.log(tigger.stripes);//gives you tigger prop
console.log(tigger.species);//gives you the proto's value if it doesn't 
//have one
console.log(tigger.getStats());
console.log(tigger.somethingelse);//if the property does not exisit in
//object or proto chain, you just get undefined
animal.legs=0;
console.log(animal);
console.log(tigger.legs)

