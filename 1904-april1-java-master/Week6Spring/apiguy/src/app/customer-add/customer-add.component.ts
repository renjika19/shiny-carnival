import { CustomerService } from './../customer.service';
import { Customer } from './../customer';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {

  model = new Customer(0, "first", "last", "email")

  constructor(private cs: CustomerService) { }

  ngOnInit() {
  }

  addCustomer() {
    this.cs.addCustomer(this.model).subscribe(x=>{"this does nothing"});
    this.model = new Customer(0, "", "", "");
  }

}
