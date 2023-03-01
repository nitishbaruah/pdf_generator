> # PDF Generator
Dynamic pdf generator (Backend API) <br>
Clone repo and run on IDE. <br>

API  : http://localhost:8080/pdf/generator <br>

## Input 
``` 
  {
      "seller": "XYZ Pvt. Ltd.",
      "sellerGstin": "29AABBCCDD121ZD",
      "sellerAddress": "New Delhi, India",
      "buyer": "Vedant Computers",
      "buyerGstin": "29AABBCCDD131ZD",
      "buyerAddress": "New Delhi, India",
      "items": [
                  {
                      "name": "Product 1",
                      "quantity": "12 Nos",
                      "rate": 123.00,
                      "amount": 1476.00
                   }
                ]
}

```
## Output<br>
<img width="640" alt="Screenshot 2023-03-01 072317" src="https://user-images.githubusercontent.com/40658745/222025520-f3f50f4f-59ca-4e53-b179-a26d4926af9f.png">




