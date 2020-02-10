# API Contract

1. Create a reservation
    * **Endpoint**
        *   POST /api/v1/reservation/

    * **Request parameters**
        * None

    * **Request Body**
        * See /sample-req-resp/post_create_reservation_request.json

    * **Response Codes**
    
        200 Success
        
        400 Bad Request 
        
        401 Unauthorized
        
        404 Not Found
        
        500 Internal Server Error

    * **Response Body**
        * See /sample-req-resp/get_reservation_by_id_response.json

2. Update a reservation
    * **Endpoint**
        *   PUT /api/v1/reservation/{bookingNumber}

    * **Request parameters**
        * bookingNumber

    * **Request Body**
        * See /sample-req-resp/put_reservation_by_id_request.json

    * **Response Codes**
    
        200 Success
        
        400 Bad Request 
        
        401 Unauthorized
        
        404 Not Found
        
        500 Internal Server Error

    * **Response Body**
        * None

3. Delete a reservation
    * **Endpoint**
        *   DELETE /api/v1/reservation/{bookingNumber}

    * **Request parameters**
        * bookingNumber

    * **Request Body**
        * None

    * **Response Codes**
    
        204 No Content(successful deletion)
        
        400 Bad Request 
        
        401 Unauthorized
        
        404 Not Found
        
        500 Internal Server Error

    * **Response Body**
        * None

4. Retrive a reservation using email
    * **Endpoint**
        *   GET /api/v1/reservation?email_address={email}

    * **Request parameters**
        * email_address

    * **Request Body**
        * None

    * **Response Codes**
    
        200 Success
        
        400 Bad Request 
        
        401 Unauthorized
        
        404 Not Found
        
        500 Internal Server Error

    * **Response Body**
        * See /sample-req-resp/get_reservation_by_email_response.json
        
5. Retrieve a reservation using booking Number
    * **Endpoint**
        *   GET /api/v1/reservation/{bookingNumber}

    * **Request parameters**
        * bookingNumber

    * **Request Body**
        * None

    * **Response Codes**
    
        200 Success
        
        400 Bad Request 
        
        401 Unauthorized
        
        404 Not Found
        
        500 Internal Server Error

    * **Response Body**
        * See /sample-req-resp/get_reservation_by_id_response.json