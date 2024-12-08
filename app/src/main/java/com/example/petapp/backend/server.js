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
        res.json(pets);
    } catch (error) {
        console.error('Error fetching pets:', error.message);
        res.status(500).json({ error: error.message });
    }
});


app.post('/pets', async (req, res) => {
    const { name, imageUrl, caloriesBurned, latitude, longitude } = req.body;
    const newPet = new Pet({
        name,
        imageUrl,
        caloriesBurned,
        latitude,
        longitude,
    });

    try {
        await newPet.save();
        res.status(201).json(newPet);
    } catch (error) {
        console.error('Error adding pet:', error.message);
        res.status(500).json({ error: error.message });
    }
});


app.put('/pets/:id', async (req, res) => {
    const { name, imageUrl, caloriesBurned, latitude, longitude } = req.body;
    try {
        const updatedPet = await Pet.findByIdAndUpdate(req.params.id, {
            name,
            imageUrl,
            caloriesBurned,
            latitude,
            longitude,
        }, { new: true });

        if (!updatedPet) {
            return res.status(404).json({ message: 'Pet not found' });
        }

        res.json(updatedPet);
    } catch (error) {
        console.error('Error editing pet:', error.message);
        res.status(500).json({ error: error.message });
    }
});


app.delete('/pets/:id', async (req, res) => {
    try {
        const deletedPet = await Pet.findByIdAndDelete(req.params.id);
        if (!deletedPet) {
            return res.status(404).json({ message: 'Pet not found' });
        }
        res.status(200).json({ message: 'Pet deleted successfully' });
    } catch (error) {
        console.error('Error deleting pet:', error.message);
        res.status(500).json({ error: error.message });
    }
});


app.get('/', (req, res) => {
    res.send('Welcome to the Pet Tracking API!');
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, '0.0.0.0', () => {
    console.log(`Server running on http://localhost:${PORT}`);
});
