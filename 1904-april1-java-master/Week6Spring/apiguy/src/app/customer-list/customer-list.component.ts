import { CustomerService } from './../customer.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customer_list = [];

  constructor(private cs: CustomerService) { }

  ngOnInit() {
    this.refreshList();
  }

  refreshList() {
    this.cs.getCustomers().subscribe(x => this.customer_list = JSON.parse(x));
  }

}
