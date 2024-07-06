import React from 'react';
import Calculator from './Calculator';
import Navbar from './Navbar'; // Import the Navbar component
import './App.css';

const App = () => {
  return (
    <div className="app">
      <Navbar /> {/* Include the Navbar component */}
      <div className="calculator-wrapper">
        <Calculator />
      </div>
    </div>
  );
};

export default App;
