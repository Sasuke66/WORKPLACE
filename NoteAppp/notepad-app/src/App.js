// src/App.js
import React from 'react';
import Notepad from './Notepad';
import './index.css'; // Ensure Tailwind CSS and custom CSS are imported

function App() {
  return (
    <div className="flex justify-center items-center h-screen background-stardust">
      <div className="stardust"></div>
      <Notepad />
    </div>
  );
}

export default App;
