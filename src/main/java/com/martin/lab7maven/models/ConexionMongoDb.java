package com.martin.lab7maven.models;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ConexionMongoDb {
    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DATABASE_NAME = "ventas";
    private static MongoClient mongoClient;
    private static MongoDatabase database;
   
    
    private ConexionMongoDb() {
    }
    
    public static synchronized MongoDatabase obtenerConexion() {
        if(database == null){
            mongoClient = new MongoClient(HOST, PORT);
            database = mongoClient.getDatabase(DATABASE_NAME);
        }
        return database;
    }
    
    public static synchronized void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
        }
        database = null;
    }
}
