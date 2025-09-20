export class TransactionTS {
    transactionId?: number;
    accountId: string;
    amount: number;
    transactionDate: Date;
    transactionType: string;

    constructor(accountId: string, amount: number, transactionDate: Date, transactionId?: number) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    displayInfo() {
        console.log(`Transaction ID: ${this.transactionId}`);
        console.log(`Account ID: ${this.accountId}`);
        console.log(`Amount: ${this.amount.toFixed(2)}`);
        console.log(`Transaction Date: ${this.transactionDate}`);
        console.log("------");
    }
}

const transaction = new TransactionTS("1", 50.00, new Date(), 1);
transaction.displayInfo();