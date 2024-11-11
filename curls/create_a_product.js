const url = 'http://localhost:8080/api/inventory/product';

// Function to generate random values
function getRandomProduct() {
    const randomId = Math.floor(Math.random() * 10000);
    const randomPrice = (Math.random() * 100).toFixed(2); // Random price between 0 and 100

    return {
        name: `Product_${randomId}`,
        description: `This is a description for product ${randomId}`,
        price: parseFloat(randomPrice)
    };
}

// Get random product data
const data = getRandomProduct();

fetch(url, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data)
})
.then(response => {
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    return response.json();
})
.then(data => console.log('Response:', data))
.catch(error => console.error('Error:', error));

