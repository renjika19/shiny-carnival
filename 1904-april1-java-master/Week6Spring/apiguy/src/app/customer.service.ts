import { Customer } from './customer';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from './url.service';
import { headersToString } from 'selenium-webdriver/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  headers = new HttpHeaders();

  constructor(private http: HttpClient, private url: UrlService) {
    this.headers.append('Content-Type', 'application/json');
  }

  getCustomers(): Observable<any> {
    return this.http.get(this.url.base, { responseType: "text", headers: this.headers });
  }

  addCustomer(c: Customer): Observable<any> {
    return this.http.post(this.url.base, c, {headers: this.headers});
  }
  
}
