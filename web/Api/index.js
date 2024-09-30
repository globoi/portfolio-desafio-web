const express = require('express');
const cors = require('cors');
const app = express();
const PORT = process.env.PORT || 3000;
const fs = require('fs');

app.use(cors())

app.get('/feed/page/:page', async (req, res) => {
	const page = req.params.page;
	try {
		const raw = fs.readFileSync(`./Dump/Cleared/page_${page}.json`);
		const parsed = JSON.parse(raw);
		res.send(parsed);
	} catch (e) {
		res.send({ message: "We're unable to load this page." });
	}
});

app.listen(PORT, () => {
	console.log(`API executando em http://localhost:${PORT}`);
});
