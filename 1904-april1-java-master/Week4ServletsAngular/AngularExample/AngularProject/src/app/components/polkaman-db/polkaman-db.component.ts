import { Component, OnInit } from '@angular/core';
import { Polkaman } from './polkaman/polkaman';
import { PolkaserviceService } from 'src/app/services/polkaservice.service';

@Component({
  selector: 'app-polkaman-db',
  templateUrl: './polkaman-db.component.html',
  styleUrls: ['./polkaman-db.component.css']
})
export class PolkamanDbComponent implements OnInit {
  polkamans:Polkaman[]=[]
  constructor(private ps:PolkaserviceService) { }
  //dependency inject the service

  ngOnInit() {
    this.ps
    .getAllPolkamans()
    .subscribe(
      data =>{
        console.log(data);
        this.polkamans = data;
      },
      error =>{
        console.log(error);
      }
    )
  }

}
