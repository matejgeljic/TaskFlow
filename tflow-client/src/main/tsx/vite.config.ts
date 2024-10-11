import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react';
import svgrPlugin from 'vite-plugin-svgr';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react(), svgrPlugin()],
  preview: {
    host: true,
    port: 3022,
    strictPort: true
  },
  server: {
    host: true,
    port: 3000,
    strictPort: true,
  }
})
