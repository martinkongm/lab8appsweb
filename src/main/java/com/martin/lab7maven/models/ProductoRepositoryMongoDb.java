package com.martin.lab7maven.models;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;
import org.bson.Document;

public class ProductoRepositoryMongoDb implements ProductoDao {

    private final MongoDatabase database;
    private final MongoCollection<Document> productoCollection;

    public ProductoRepositoryMongoDb() {
        this.database = ConexionMongoDb.obtenerConexion();
        this.productoCollection = database.getCollection("producto");
    }

    @Override
    public void registrar(Producto producto) {
        Document doc = new Document("codigo", producto.codigo())
                .append("nombre", producto.nombre())
                .append("precio", producto.precio())
                .append("stock", producto.stock());
        productoCollection.insertOne(doc);
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        for (Document doc : productoCollection.find()) {
            Producto producto = new Producto(
                    doc.getInteger("codigo"),
                    doc.getString("nombre"),
                    doc.getDouble("precio"),
                    doc.getInteger("stock")
            );
            productos.add(producto);
        }
        return productos;
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> productos = new ArrayList<>();
        // Creamos un patrón de expresión regular para simular el comportamiento de LIKE en SQL
        Pattern pattern = Pattern.compile(".*" + nombre + ".*", Pattern.CASE_INSENSITIVE);
        Document query = new Document("nombre", new Document("$regex", pattern));
        for (Document doc : productoCollection.find(query)) {
            Producto producto = new Producto(
                    doc.getInteger("codigo"),
                    doc.getString("nombre"),
                    doc.getDouble("precio"),
                    doc.getInteger("stock")
            );
            productos.add(producto);
        }
        return productos;
    }

    @Override
    public Producto obtenerPorId(Integer id) {
        Document query = new Document("codigo", id);
        Document doc = productoCollection.find(query).first();
        if (doc != null) {
            return new Producto(
                    doc.getInteger("codigo"),
                    doc.getString("nombre"),
                    doc.getDouble("precio"),
                    doc.getInteger("stock")
            );
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        Document query = new Document("codigo", id);
        productoCollection.deleteOne(query);
    }

}
