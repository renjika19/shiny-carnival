import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Polkaman } from '../components/polkaman-db/polkaman/polkaman';


/*
  Services will use the @Injectable decorator. this decorator is used to
  let angular know that this component/service should expect to be injected
  into other pieces, or itself expecting something to be injected into it.

  note that in the previous example, we should have made a service in order
  to dependency inject, but we didn't because it was just an example

  a service provides data to components. unlike components, they do not
  have their own view
*/
@Injectable({
  providedIn: 'root' //denotes that this serivice is available application
                          //wide
})
export class PolkaserviceService {

  constructor(private http:HttpClient) { }
  getAllPolkamans(){
    return this.http.get<Polkaman[]>(
      "http://localhost:8085/190401PolkamanServlet/FetchPolkamansServlet"

      //this returns an observable with information from our call
      //to the fetch polkamans servlet (which returns a JSON
      //representation of all of our polkamans in our db)
    )
  }
}
