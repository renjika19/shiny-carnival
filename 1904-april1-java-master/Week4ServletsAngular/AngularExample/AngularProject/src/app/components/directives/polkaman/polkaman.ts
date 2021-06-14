export class Polkaman{
    constructor(
        public name:string,
        public type:string,
        public time:number
    ){
        /*
            By setting the constructor to public, we automatically
            generate setter and getters for the parameters in the
            constructor. It is a quality of life shortcut.
        */
    }
}