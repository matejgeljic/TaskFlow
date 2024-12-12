/** @type {import('tailwindcss').Config} */
export default {
    content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
    theme: {
        colors: {
            transparent: 'transparent',
            primary: '#5570F1',
            primaryPressed: '#5B6EC6',
            secondary: '#FFCC91',
            secondaryPressed: '#D9AD7B',
            action: '#32936F',
            actionPressed: '#458B71',
            danger: '#F57E77',
            dangerPressed: '#C95F58',
            base: '#F4F5FA',
            font: '#53545C',
            fontLight: '#BEC0CA',
            white: '#FFFFFF',
            black: '#1C1D22'
        },
        fontFamily: {
            poppins: ["Poppins", "sans-serif"],
        },
    },
    plugins: [],
}