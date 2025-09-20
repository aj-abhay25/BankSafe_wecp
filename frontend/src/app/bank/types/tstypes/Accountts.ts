export class AccountTS {
    accountId?: string;
    customerId: string;
    balance: number;
    constructor( customerId: string, balance: number,accountId?:string,) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.balance = balance;
    }

    displayInfo() {
        console.log(`Account ID: ${this.accountId}`);
        console.log(`Customer ID: ${this.customerId}`);
        console.log(`Balance: ${this.balance.toFixed(2)}`);
    }
}

const account = new AccountTS("1",1000.00,"1");
account.displayInfo();