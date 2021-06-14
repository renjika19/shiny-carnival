window.onload = function () {
    bulba = JSON.parse(bulba);
    // console.log(bulba);
    populateDex(bulba);

    document.getElementById("pokemonSubmit").onclick = getPokemon;
}

function populateDex(pokemon) {
    var image = document.getElementById('pokemonImg');//img tag
    var name = document.getElementById('pokemonName'); //p tag
    // var stats = document.getElementById('stats');
    image.src = pokemon.sprites.front_default;
    image.alt = pokemon.name;
    name.innerHTML = pokemon.name;
}

/*
    AJAX is a developer's dream, because you can:
    -update a webpage without reloading it
    -request data from a server - after the page has loaded
    -receive data from a server - after the page has loaded
    -send data to a server - in the background

    AJAX = Asynchronous JavaScript and XML

    AJAX is NOT a programming language.

    AJAX uses a comibination of:
    broswer built-in XMLHttpRequest object (to request data from a web
        server) javascript and html dom (to display or use the data)

    AJAX is still javascript
    it just accomplishes it goals in a unique way
    note that it works both with JSON and XML.


*/

function getPokemon() {
    var id = document.getElementById('pokemonId').value;

    //STEP 1: create new XML HTTP Request
    var xhttp = new XMLHttpRequest();
    //STEP 2: set a callback function to ReadyStateChange
    xhttp.onreadystatechange = parsePokemon;
    //STEP 3: Open the request
    xhttp.open("GET", "https://pokeapi.co/api/v2/pokemon/"+id);
    //STEP 4: send the request
    xhttp.send();


    function parsePokemon() {
        var pokeImg = document.getElementById("pokemonImg");

        /*
            0:UNSENT: open() has not yet been called
            1:OPENED: open() has been called.
            2:HEADERS_RECEIVED: send() has been called. Headers of the
            response and the status are now available
            3:LOADING: Downloading the response. responseText is now available
            4:DONE: operation is complete
        */

        //note that we do not want to do anything until success is acheived:
        if (xhttp.readyState === 4 && xhttp.status == 200) {
            // console.log('ready state: ' + xhttp.readyState);
            // console.log('http status: ' + xhttp.status);
            let response = xhttp.responseText;
            response = JSON.parse(response);
            populateDex(response);
        } else {
            // console.log('ready state: '+ xhttp.readyState);
            // console.log('ready status: '+ xhttp.readyStatus);
            //either we are currently loading  or we have failed
            pokeImg.setAttribute("src", "images/RotatingPokeball.gif");
            pokeImg.setAttribute("alt", "Loading...") //loading screen stuff
        }
    }
}