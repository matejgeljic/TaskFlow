/** @type {import('tailwindcss').Config} */
export default {
    content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
    theme: {
        colors: {
            transparent: 'transparent',
            primary: '#5570F1',
            primaryPressed: '#5B6EC6',
            secondary: '#32936F',
            secondaryPressed: '#458B71',
            danger: '#F57E77',
            dangerPressed: '#C95F58',
            base: '#F4F5FA',
            font: '#53545C',
            white: '#FFFFFF'
        },
        fontFamily: {
            poppins: ["Poppins", "sans-serif"],
        },
    },
    plugins: [],
}