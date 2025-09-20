import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TransactionTS } from '../../types/tstypes/Transactionts';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.scss']
})
export class TransactionComponent implements OnInit {
  transactionForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.transactionForm = this.fb.group({
      transactionId: [null],
      accountId: [null, Validators.required],
      transactionType: [null, Validators.required],
      amount: [null, [Validators.required, Validators.min(0)]],
      transactionDate: [null, Validators.required],
    });
  }

  onSubmit() {
    if (this.transactionForm.valid) {
      const formData = this.transactionForm.value;
      const transaction = new TransactionTS(
        formData.accountId,
        formData.amount,
        formData.transactionDate,
        formData.transactionType,
      );

    }
  }
}