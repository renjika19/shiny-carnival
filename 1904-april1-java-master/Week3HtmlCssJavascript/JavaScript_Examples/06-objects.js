//one way of creating an object in js is by using a literal:
let personLiteral = {
    name:'Ashe Caughtem-Mall',
    haircolor: 'black',
    numPolkamans: 151
}
console.log(personLiteral);
console.log(`
    to access objects you can use . or bracket notation
    you should use . notation unless you have a good reason not o
    name = ${personLiteral.name}
    name = ${personLiteral['name']}`
);
//you can also add properties to existing objects:
personLiteral.gympasses = 8;
//if you set a property of an object that does not exist, js will add it to
//the object
console.log(personLiteral);

//remember that funcitons are objects as well
//you can create a fucntion/object in the following way
function Person(name,haircolor,gympasses){
    //in the context here, the 'this' keyword refers to
    //the person object that 'ownns' these properties
    this.name = name;
    this.haircolor = haircolor;
    this.gympasses = gympasses;
    this.IChooseMe = function(){
        console.log(`I choose ${this.name}`);
    }
};

let JerryO = new Person('JerryO','brown',10);
console.log(JerryO);
JerryO.IChooseMe();
//Classes were introduced in ES6
class PersonClass{
    constructor(name,haircolor,gympasses){
        this.name = name;
        this.haircolor = haircolor;
        this.gympasses = gympasses;
    }

    IChooseMe(){
        console.log(`PersonClass I choose ${this.name}`);
    }
}
let rock = new PersonClass('Rock', 'brown/spikey',1);
console.log(rock);