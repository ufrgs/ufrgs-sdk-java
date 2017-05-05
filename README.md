# ufrgs-sdk-java
This SDK provides a simple way to communicate with the UFRGS API and its various endpoints.

Below a list of all available scopes:

### SCOPES
- **Meus Dados** this scope provides information about the user as well as their photo.
- **Biblioteca** this scope provides information related to loans made at the UFRGS library as well as enpoints necessary for their renewal.
- **Caronas** this scope provides all the endpoints needed for the Ufrgs Carona app [still in development]

### SDK ORGANIZATION
SDK provides a manager for each of the scopes plus an additional manager for token management.

- **UfrgsTokenManager**
- **UfrgsUserDataManager**
- **UfrgsLibraryManager**
- **UfrgsCaronasManager**

# Setup

## 1. Provide the gradle dependency

```gradle
Not yet available
```

## 2. Initialize the SDK
Be sure to initialize your SDK before making any calls.

```java
UfrgsAPI.initialize(
  false  /* setApiToProduction */, 
  "CLIENT_AB" /* clientId */, 
  "SECRET_AB" /* clientSecret */, 
  "SCOPE_AB" /* scope */, 
  "GRANT_AB" /* grantType */);
```


This information is currently restricted to UFRGS's CPD.

## 3. Login/Request token

```java
requestNewToken(context /* context */, 
  "12345" /* username */,
  "password" /* password */, 
  new UfrgsTokenManager.OnTokenListener() {
    @Override
    public void onTokenReady(UfrgsToken token) {
      
      /* Token ready */
    
    }

    @Override
    public void onError(String error) {
    
      /* Handle errors */
    
    } /* callback */);
```

After getting the token from the user you can already initiate calls to the requested scopes.

