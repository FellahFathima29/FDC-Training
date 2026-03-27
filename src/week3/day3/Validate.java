package week3.day3;

import java.util.Scanner;

public class Validate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Status Code: ");
        int statusCode = sc.nextInt();
        try {
            handleResponse(statusCode);
        } catch (ClientErrorAPIException | ServerErrorAPIException | InvalidAPIResponseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void handleResponse(int statusCode)
            throws ClientErrorAPIException, ServerErrorAPIException, InvalidAPIResponseException {

        if (statusCode >= 200 && statusCode <= 299) {
            System.out.println("SUCCESS");
        } else if (statusCode >= 400 && statusCode <= 499) {
            throw new ClientErrorAPIException("Client error occurred");
        } else if (statusCode >= 500 && statusCode <= 599) {
            throw new ServerErrorAPIException("Server error occurred");
        } else throw new InvalidAPIResponseException("Invalid error message");
    }

    static class ClientErrorAPIException extends Exception {
        public ClientErrorAPIException(String message) {
            super(message);
        }
    }

    static class ServerErrorAPIException extends Exception {
        public ServerErrorAPIException(String message) {
            super(message);
        }
    }

    static class InvalidAPIResponseException extends Exception {
        public InvalidAPIResponseException(String message) {
            super(message);
        }
    }
}


