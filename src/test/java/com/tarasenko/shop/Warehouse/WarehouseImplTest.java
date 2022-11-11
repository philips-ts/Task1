package com.tarasenko.shop.warehouse;


class WarehouseImplTest {
//    WarehouseDao warehouse;
//
//    @TempDir
//    static Path tempDir;
//    static Path tempFile;
//
//    @BeforeAll
//    static void setUp() throws IOException {
//        tempFile = Files.createFile(tempDir.resolve("bucket_test"));
//    }
//
//    @BeforeEach
//    void setUpEach() {
//        warehouse = new WarehouseImpl();
//
//        Food food = new Food();
//        food.setName("Apple");
//        food.setPrice(50);
//        food.setMaxStorageTemperature((short)25);
//        food.setDateOfManufacture(LocalDate.of(2023,3,9));
//        warehouse.addProduct(food);
//
//        Food food2 = new Food();
//        food2.setName("Cookie");
//        food2.setPrice(80);
//        food2.setMaxStorageTemperature((short)30);
//        food2.setDateOfManufacture(LocalDate.of(2023,2,20));
//        warehouse.addProduct(food2);
//
//        NotFood notFood = new NotFood();
//        notFood.setName("Pencil");
//        notFood.setPrice(80);
//        notFood.setDateOfManufacture(LocalDate.of(2020,12,2));
//        notFood.setBreakable(false);
//        warehouse.addProduct(notFood);
//    }
//
//    @Test
//    void addProduct_ShouldThrowsException_whenProductIsNull() {
//        Assertions.assertThrows(RuntimeException.class, () -> warehouse.addProduct(null));
//    }
//
//    @Test
//    void addProduct_ShouldAddProductToWarehouse_whenParametersAreValid() {
//        final NotFood notFood = new NotFood();
//        notFood.setName("Test");
//        notFood.setPrice(111);
//        notFood.setDateOfManufacture(LocalDate.of(2020,1,2));
//        warehouse.addProduct(notFood);
//
//        Assertions.assertEquals(warehouse.getProducts().size(), 4);
//    }
//
//    @Test
//    void removeProduct_ShouldReturnTrue_whenProductIdIsCorrect() {
//        Assertions.assertTrue(warehouse.removeProductByName("Cookie"));
//        Assertions.assertTrue(warehouse.removeProductByName("Pencil"));
//    }
//    @Test
//    void removeProduct_ShouldReturnFalse_whenProductIdIsIncorrect() {
//        Assertions.assertThrows(Exception.class, () -> warehouse.removeProductByName(null));
//    }
//
//
//    @Test
//    void getProductByName_ShouldReturnEmptyOptional_whenProductNameIsNull() {
//        Assertions.assertTrue(warehouse.getProductByName(null).isEmpty());
//    }
//
//    @Test
//    void getProductByName_ShouldReturnProduct_whenProductNameIsCorrect() {
//        String actualProductName = "Cookie";
//        Optional<Product> productOptional = warehouse.getProductByName(actualProductName);
//        Assertions.assertTrue(productOptional.isPresent());
//        Assertions.assertEquals(productOptional.get().getName(), actualProductName);
//    }
//
//    @Test
//    void getProducts_ShouldReturnProductList() {
//        List<Product> products =  warehouse.getProducts();
//        Assertions.assertEquals(products.size(), 3);
//    }
//
//
//    @Test
//    void save_shouldSaveDataToFile() throws IOException {
//        Assertions.assertTrue(warehouse.save(tempFile.toString()));
//
//        boolean isExists = Files.exists(tempFile.toAbsolutePath());
//        Assertions.assertTrue(isExists);
//
//        long expectedFileSize = Files.size(tempFile.toAbsolutePath());
//        Assertions.assertNotEquals(expectedFileSize, 0);
//    }
}