- Suppose we have a payment system that use credit card
working with cash as cent and we want to add one feature to 
work with PayPayPayment that is from third party library 
that uses cash as dollar for payment.
- In this context the cash type in cent cannot use with paypal payment
because it uses dollar type
---
- **Solution**
  - We create adapter class to make exist code or payment can work with
  the third-party library as PayPalPayment