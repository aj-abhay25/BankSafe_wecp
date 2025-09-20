import { Component } from '@angular/core';
import { CustomerTS } from '../../types/tstypes/Customerts';

@Component({
  selector: 'app-customerarray',
  templateUrl: './customerarray.component.html',
  styleUrls: ['./customerarray.component.css']
})
export class CustomerarrayComponent {
  customers: CustomerTS[] = [
   new CustomerTS('1', 'abc', 'abcd1@gmail.com','pswrd','user1','developer')
  ];
}