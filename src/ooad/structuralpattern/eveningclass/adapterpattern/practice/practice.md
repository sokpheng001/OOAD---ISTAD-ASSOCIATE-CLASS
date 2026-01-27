Adapter Pattern Practice: ABA payment with Khmer currency
--
Suppose we are working on ABA Banking Service, and containing class as below
--
class Account(id, balance, accNumber,createdDate)
interface PaymentService: payAsDollar(double dollar):Boolean,
class BankingService implements Payment
third-party interface RielCurrecyPayment: payAsRiel(double riel):Boolean
-
Implement the existing payment as dollar to work with riel payment using Adapter Pattern
