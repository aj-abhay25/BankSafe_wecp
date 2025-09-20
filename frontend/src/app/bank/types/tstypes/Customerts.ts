export class CustomerTS {
    customerId?: string;
    name: string;
    email: string;
    password:string;
    username:string;
    role?:string;
  
      constructor(name: string, email: string, username: string, password: string, role: string, customerId?:string) {
          this.customerId = customerId;
          this.name = name;
          this.email = email;
          this.username = username;
          this.password = password;
          this.role = role;
      }
  
      displayInfo() {
          console.log(`Customer ID: ${this.customerId}`);
          console.log(`Name: ${this.name}`);
          console.log(`Email: ${this.email}`);
          console.log(`Username: ${this.username}`);
          console.log(`Password: ${this.password}`);
          console.log(`Role: ${this.role}`);
          console.log("------");
      }
  }
  const customer = new CustomerTS( "John Doe", "john@example.com", "john_doe", "password123", "User","1");
  customer.displayInfo();
  
  
  
  
  