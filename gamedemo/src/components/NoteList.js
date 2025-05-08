import React, { useEffect, useState } from 'react';
import { getActivityList } from '../api';

const NoteList = ({ type }) => {
    const [notes, setNotes] = useState([]);

    useEffect(() => {
        const fetchNotes = async () => {
            try {
                // ... existing code ...
                const response = await getActivityList();
                // Transform activity data to note format
                const transformed = response.data.map(activity => ({
                    id: activity.id,
                    title: activity.name,
                    content: activity.description,
                    type: 'activity'
                }));
                setNotes(transformed);
            } catch (error) {
                console.error('数据加载失败:', error);
            }
        };
        fetchNotes();
    }, [type]);

    return (
        <div className="note-grid">
            {notes.map(note => (
                <div key={note.id} className="note-card">
                    <h3>{note.title}</h3>
                    <p>{note.content}</p>
                    {note.images && <img src={note.images} alt={note.title} />}
                </div>
            ))}
        </div>
    );
};

export default NoteList;