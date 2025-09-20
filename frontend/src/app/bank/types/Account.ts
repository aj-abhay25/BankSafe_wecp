import { Customer } from "./Customer";
export class Account {
    accountId?: number;
    customer: Customer;
    balance: number;

    constructor(data: any) {
        // if(this.accountId)
        this.accountId = data?.accountId;
        this.customer = data?.customer;
        this.balance = data?.balance !== undefined ? data.balance : 0;
    }
}