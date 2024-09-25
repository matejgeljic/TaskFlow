-- Create Customer Table
CREATE TABLE customer (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    phone VARCHAR(20),
    address VARCHAR(255),
    city VARCHAR(100),
    zip_code VARCHAR(20),
    country VARCHAR(100)
);

-- Create Product Table
CREATE TABLE product (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DOUBLE PRECISION NOT NULL,
    rating DOUBLE PRECISION CHECK (rating >= 0 AND rating <= 5),
    stock_quantity INT NOT NULL CHECK (stock_quantity >= 0),
    is_archived BOOLEAN DEFAULT FALSE
);

-- Create Order Item Table
CREATE TABLE order_item  (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    quantity INT NOT NULL CHECK (quantity >= 1),
    product_id UUID NOT NULL,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE
);

-- Create Sales Order Table
CREATE TABLE sales_order (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    customer_id UUID NOT NULL,
    status VARCHAR(20) NOT NULL,
    total_price DOUBLE PRECISION NOT NULL CHECK (total_price >= 0),
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE SET NULL
);

-- Create mapping between Sales Order and Order Items (OneToMany relationship)
ALTER TABLE order_item
    ADD COLUMN sales_order_id UUID,
ADD CONSTRAINT fk_sales_order FOREIGN KEY (sales_order_id) REFERENCES sales_order (id) ON DELETE CASCADE;
