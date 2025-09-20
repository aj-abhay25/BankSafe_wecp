import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {  CustomerTS } from '../../types/tstypes/Customerts';
import { of } from 'rxjs';
 
@Component({
  selector: 'app-customersample',
  standalone: true,
  imports: [],
  templateUrl: './customersample.component.html',
  styleUrls: ['./customersample.component.css']
})
export class CustomersampleComponent {
  customer : any = new CustomerTS("xyz","xyz@gmail.com","xy","zzz","yyy","3")
}