# Makeup & Skin Care Store Website

## Interactive Application Where Users Can Shop For Makeup and Skin Care

- **What will the application do?**

The application is an online makeup/skincare store where users can visit and purchase makeup/skincare products from. It has a shopping cart that users can use to add interested products to and stores the products there even after the users exit the application. Application will include products' prices, ingredients, brands, etc.. If the product is out of stock, users can register to be notified when it is in stock again. Application includes customer service, which the users can ask questions to, and a product rating system that will not only allow users to rate purchased products but will also allow them to view the overall rating of every products. If time and skills allow, I will try to add a delivery information page (which tells you the estimated delivery time and the package ID/fee for a purchased product) to the application.

- **Who will use it?**

Anyone who want to purchase or is interested in makeup or skincare products.

- **Why is this project of interest to you?**

I have been purchasing and learning about makeup and skincare products from websites like the one I'm trying to design since I am thirteen. This project provides me the opportunity to not only create such website by myself but also add in useful tools that I wished other websites have but they don't.


## User Stories

- As a user, I want to be able to add and delete a product from my shopping cart
- As a user, I want to be able to view the list of products in my shopping cart
- As a user, I want to be able to select a product from my shopping cart and view its product information page
- As a user, I want to be able to see the product's price, brand, product ID, total purchased times, rating and ingredients (maybe more) on the product information page
- As a user, I want to be able to see the number of products in my shopping cart and the total price of all the products in my shopping cart
- As a user, I want to be able to rate a purchased item
- As a user, I want to be able to register for restock notification if product is out of stock.
-As a user, I want to be able to contact customer service for support.
- (Maybe) As a user, I want to be able to track shipping.
- As a user, I want to be able to save my shopping cart and purchased list to file and have the option to do so or not
- As a user, when I want to be able to load my shopping cart and purchased list from file and resume exactly where they were left off at some earlier time. I want to have the option to do so or not.


## Instructions for End User
- You can add a product to shopping cart by clicking "Start Shopping" on menu panel, then check one product you want to add to cart, then click the "Add to Shopping Cart" button.
- You can generate the first required action related to the user story "view shopping cart" by clicking view shopping cart button on menu page.
- You can generate the first of the two additional required actions that are related to the required user story "a button that adds products to shopping cart" by first clicking "Start Shopping" button on menu page. The "Add to Shopping Cart" button will appear.
- You can generate the second additional required action related to the user story "remove product from shopping cart" by first clicking "View Shopping Cart" button on menu page, then select the product you want to remove, then press "Remove item from cart" button.
- You can generate the visual component by pressing "Quit" button on menu page
- You can save the state of the application to file by pressing the "Save Progress" button on menu page
- You can load the state of the application to file by pressing the "Load Progress" button on menu page.

## Phase 4: Task 2
Added Tom Ford Eye Color Quad Eye Shadow to shopping cart.  
Added SKII Facial Treatment Cleanser to shopping cart.  
Added Fenty Beauty Pro Filtr Soft Matte Longwear Liquid Foundation to shopping cart.  
Added The Ordinary Hyaluronic Acid 2% + B5 Hydrating Serum to shopping cart.  
Removed Tom Ford Eye Color Quad Eye Shadow product from shopping cart.  
Removed SKII Facial Treatment Cleanser product from shopping cart.  
Removed Fenty Beauty Pro Filtr Soft Matte Longwear Liquid Foundation product from shopping cart.  
Removed The Ordinary Hyaluronic Acid 2% + B5 Hydrating Serum product from shopping cart.

## Phase 4: Task 3
I would first refractor my Product interface. I could refractor it into an abstract class, because the methods and local variables in MakeUp and Skincare classes (which implements Product) are almost identical. After refractoring the Product interface into an abstract class, I will have MakeUp and SkinCare classes extends the new abstract class, then I will remove the duplicated code from the subclasses and use the inherited version from the superclass. By doing so, I can decrease code duplication and chance of error.
Similarly, I find a considerable amount of code duplication in my ShoppingCart and PurchasedList classes. I would, again, refractor these classes into an abstract class, maybe call it productList. Then, after implementing the shared methods and local variables in the new abstract class, I would have ShoppingCart and PurchasedList classes extends the new abstract class. Then, I would delete duplicated codes from the subclasses and use the inherited version from the superclass This refractoring would decrease code duplication and chance of error.
