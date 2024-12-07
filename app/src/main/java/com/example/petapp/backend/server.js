const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());


const connectionString = 'mongodb+srv://Ashik:Ashik1114@cluster0.c1i9y.mongodb.net/pets?retryWrites=true&w=majority&appName=Cluster0';


mongoose.connect(connectionString, { retryWrites: true, w: 'majority' })
    .then(() => {
        console.log('Connected to MongoDB');
    })
    .catch(err => {
        console.error('Failed to connect to MongoDB', err);
    });

const petSchema = new mongoose.Schema({
    name: String,
    imageUrl: String,
    caloriesBurned: Number,
    latitude: Number,
    longitude: Number,
});

const Pet = mongoose.model('Pet', petSchema);


app.get('/pets', async (req, res) => {
    try {
        const pets = await Pet.find();
        console.log(pets);
        res.json(pets);
    } catch (error) {
        console.error('Error fetching pets:', error.message);
        res.status(500).json({ error: error.message });
    }
});


app.get('/', (req, res) => {
    res.send('Welcome to the Pet Tracking API!');
});


const PORT = process.env.PORT || 3000;
app.listen(PORT, '172.20.10.6', () => {
    console.log(`Server running on http://172.20.10.6:${PORT}`);
});
