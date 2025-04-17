# Genius-Inspired Lyrics Platform 🎤

Welcome to the Lyrics Editing Console App — a Java-based application inspired by the Genius platform, where users suggest lyric edits, and artists/admins manage them.

---

## 🚀 Features

### 👤 Users:
- Sign up / Login
- Search artists, songs, albums
- View lyrics
- Suggest edits
- Follow artists
- View profile (comments + followed artists)

### 🎤 Artists:
- Login
- View edit requests (only for their own songs)
- Approve / Reject suggestions

### 🛡️ Admin:

- Login
- View all lyric edit requests
- Approve / Reject any request
-Notice! for login as admin use this username AdmiNNN and this password Admin!Gen1us.

---

## 💾 Data Management

All data is saved in local `.json` files. The application reads and writes to these files using simple file I/O with JSON format.

Main classes for data handling:
- `SaveData.java`: Handles saving and loading of users, songs,increase view, and requests.
- `ArtistData.java`: Manages artist-specific data and their songs.

---

## 🧪 How to Run

### 1. Clone the Repository
```bash
git clone <repository_url>
