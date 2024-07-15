// src/Notepad.js
import React, { useState } from 'react';
import './index.css'; // Ensure Tailwind CSS is imported

const Notepad = () => {
  const [notes, setNotes] = useState([]);
  const [note, setNote] = useState('');
  const [isEditing, setIsEditing] = useState(false);
  const [currentNote, setCurrentNote] = useState({});

  const handleInputChange = (e) => {
    setNote(e.target.value);
  };

  const addNote = () => {
    if (note.trim()) {
      setNotes([...notes, { id: Date.now(), text: note }]);
      setNote('');
    }
  };

  const deleteNote = (id) => {
    setNotes(notes.filter(note => note.id !== id));
  };

  const editNote = (note) => {
    setIsEditing(true);
    setCurrentNote(note);
    setNote(note.text);
  };

  const updateNote = () => {
    setNotes(notes.map(n => (n.id === currentNote.id ? { ...n, text: note } : n)));
    setIsEditing(false);
    setNote('');
    setCurrentNote({});
  };

  return (
    <div className="w-full max-w-4xl min-w-[300px] min-h-[400px] p-8 bg-white bg-opacity-90 rounded-lg shadow-2xl relative z-10 resize overflow-auto">
      <h1 className="text-3xl font-bold text-center text-gray-800 mb-8">Notepad</h1>
      <div className="mb-8">
        <textarea
          value={note}
          onChange={handleInputChange}
          placeholder="Write your note here..."
          className="w-full h-40 p-4 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 mb-4"
        ></textarea>
        {isEditing ? (
          <button
            onClick={updateNote}
            className="w-full px-4 py-2 bg-green-500 text-white rounded-lg hover:bg-green-600 transition"
          >
            Update Note
          </button>
        ) : (
          <button
            onClick={addNote}
            className="w-full px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600 transition"
          >
            Add Note
          </button>
        )}
      </div>
      <div className="space-y-4">
        {notes.map((note) => (
          <div key={note.id} className="flex justify-between items-start p-4 bg-gray-100 bg-opacity-90 rounded-lg shadow-lg hover:shadow-2xl transition">
            <p className="text-gray-800 flex-grow">{note.text}</p>
            <div className="flex space-x-2">
              <button
                onClick={() => editNote(note)}
                className="px-4 py-2 bg-yellow-500 text-white rounded-lg hover:bg-yellow-600 transition"
              >
                Edit
              </button>
              <button
                onClick={() => deleteNote(note.id)}
                className="px-4 py-2 bg-red-500 text-white rounded-lg hover:bg-red-600 transition"
              >
                Delete
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Notepad;
