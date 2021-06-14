import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {
  public base: string = "http://localhost:8081/api/customer/";
  public update: string = this.base + "update/";
  public delete: string = this.base + "delete/";

  constructor() { }
}
